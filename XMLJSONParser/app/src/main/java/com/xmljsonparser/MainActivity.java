package com.xmljsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
	TextView res;
	private Element element;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		res = findViewById(R.id.txtData);
	}

	public void JSONParser(View view) {
		res.setText("");
		String stringData=null;

		try {
			InputStream inputStream = getAssets().open("city.json");
			int size = inputStream.available();
			byte buffer[] = new byte[size];
			inputStream.read(buffer);
			stringData = new String(buffer);
			JSONObject jsonObject = new JSONObject(stringData);
			JSONObject cityObject = jsonObject.getJSONObject("City");
			String cityName = cityObject.getString("City-Name");
			String longitude = cityObject.getString("Longitude");
			String latitude = cityObject.getString("Latitude");
			String temperature = cityObject.getString("Temperature");
			String humidity = cityObject.getString("Humidity");

			res.setText("City Name - " + cityName + "\n\n");
			res.append("Longitude - " + longitude + "\n\n");
			res.append("Latitude - " + latitude+"\n\n");
			res.append("Temperature - " + temperature+"\n\n");
			res.append("Humidity - " + humidity+"\n\n");
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}

	public void XMLParser(View view) {
		res.setText("");
		try {
			InputStream inputStream = getAssets().open("city.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputStream);
			NodeList cityList = document.getElementsByTagName("City");
			for(int i=0; i<cityList.getLength();i++){
				Node c = cityList.item(i);
				if(c.getNodeType() == Node.ELEMENT_NODE){
					Element city = (Element) c;
					NodeList cityDetailList = city.getChildNodes();
					for(int j=0;j<cityDetailList.getLength();j++) {
						Node n = cityDetailList.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element cityDetail = (Element) n;
							String tagValue = cityDetail.getTagName();
							String value = cityDetail.getTextContent();
							Log.e("data", "parseXML: " + value);
							res.append(tagValue +" - "+value + "\n");
							res.append("\n");
						}
					}
				}
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}
}