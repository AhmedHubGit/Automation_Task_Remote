package BasePage_Mobile_Task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadCredentials {

	protected Properties Prop = null;
	protected FileInputStream LoadFile = null;

	public void ReadPropFile() throws IOException {

		Prop = new Properties();
		LoadFile = new FileInputStream("./DataFile/credentials.properties");
		Prop.load(LoadFile);

	}

		public String getuserName()  {	return Prop.getProperty("facebookUserName");}
		public String getpassword()  {	return Prop.getProperty("facebookPassword");}

	}