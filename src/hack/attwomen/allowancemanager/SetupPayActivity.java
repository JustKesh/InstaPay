package hack.attwomen.allowancemanager;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import java.lang.Math.*;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Build;

public class SetupPayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setuppay);
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * 
	 * // Inflate the menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.setup_pay, menu); return true; }
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void submitPay(View view) {
		Intent intent = new Intent(SetupPayActivity.this, PayActivity.class);
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
					"http://dmartin.org:8128/moneysend/v2/transfer");
			long reqID = 4000000008810101284L;
			long r = (long) Math.floor((Math.random() * 1000000) + 1);
			
			long newID = reqID + r;
			
			String editID = Long.toString(newID);
			Log.i("transx", editID);
			long value = (long) Math.floor((Math.random() * 50000) + 1);
			String newVal = Long.toString(value);
			Log.i("value", newVal);
			String xml_string_to_send = "<?xml version='1.0' encoding='UTF-8'?><TransferRequest><LocalDate>0412</LocalDate><LocalTime>141222</LocalTime><TransactionReference>"
					+ editID
					+ "</TransactionReference><SenderName>John Doe</SenderName><SenderAddress><Line1>123 Main Street</Line1><Line2>5A</Line2><City>Arlington</City><CountrySubdivision>VA</CountrySubdivision><PostalCode>22207</PostalCode><Country>USA</Country></SenderAddress><FundingCard><AccountNumber>5184680430000014</AccountNumber><ExpiryMonth>11</ExpiryMonth><ExpiryYear>2014</ExpiryYear></FundingCard><FundingMasterCardAssignedId>123456</FundingMasterCardAssignedId><FundingAmount><Value>"
					+ newVal
					+ "</Value><Currency>840</Currency></FundingAmount><ReceiverName>Jose Lopez</ReceiverName><ReceiverAddress><Line1>Pueblo Street</Line1><Line2>PO BOX 12</Line2><City>El PASO</City><CountrySubdivision>TX</CountrySubdivision><PostalCode>79906</PostalCode><Country>USA</Country></ReceiverAddress><ReceiverPhone>1800639426</ReceiverPhone><ReceivingCard><AccountNumber>5184680430000006</AccountNumber></ReceivingCard><ReceivingAmount><Value>182206</Value><Currency>484</Currency></ReceivingAmount><Channel>W</Channel><UCAFSupport>false</UCAFSupport><ICA>009674</ICA><ProcessorId>9000000442</ProcessorId><RoutingAndTransitNumber>990442082</RoutingAndTransitNumber><CardAcceptor><Name>My Local Bank</Name><City>Saint Louis</City><State>MO</State><PostalCode>63101</PostalCode><Country>USA</Country></CardAcceptor></TransferRequest>";

			StringEntity string_entity = new StringEntity(xml_string_to_send,
					HTTP.UTF_8);
			string_entity.setContentType("application/xml");
			httppost.setEntity(string_entity);

			BasicHttpResponse httpResponse = (BasicHttpResponse) httpclient
					.execute(httppost);
			HttpEntity response_entity = httpResponse.getEntity();
			String response_string = EntityUtils.toString(response_entity);

			Log.i("post send", response_string);
			int b = response_string.indexOf("Approved or completed successfully");
			Log.i("approve", String.valueOf(b));
			String response_text = response_string.substring(b,b+34);
			Log.i("response",response_text);
			Toast.makeText(getApplicationContext(), response_text, Toast.LENGTH_LONG).show();
		} catch (Exception ex) {
			//
		}
		

		
		startActivity(intent);
	}


	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.setuppay, container,
					false);
			return rootView;
		}
	}

}
