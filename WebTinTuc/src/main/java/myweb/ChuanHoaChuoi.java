package myweb;

public class ChuanHoaChuoi {

	public String ChuanHoa(String str)
	{
		
		//Chữ a và â, dấu
		str = str.replaceAll("&aacute;","á");
		str = str.replaceAll("&agrave;","à");
		str = str.replaceAll("&atilde;","ã");
		str = str.replaceAll("&acirc;","â");
		//in hoa
		str = str.replaceAll("&Aacute;","Á");
		str = str.replaceAll("&Agrave;","À");
		str = str.replaceAll("&Atilde;","Ã");
		str = str.replaceAll("&Acirc;","Â");
		//chữ o và ô, dấu
		str = str.replaceAll("&oacute;","ó");
		str = str.replaceAll("&ograve;","ò");
		str = str.replaceAll("&otilde;","õ");
		str = str.replaceAll("&ocirc;","ô");
		//in hoa
		str = str.replaceAll("&Oacute;","Ó");
		str = str.replaceAll("&Ograve;","Ò");
		str = str.replaceAll("&Otilde;","Õ");
		str = str.replaceAll("&Ocirc;","Ô");
		//Chữ e và ê, dấu
		str = str.replaceAll("&eacute;","é");
		str = str.replaceAll("&egrave;","è");
		str = str.replaceAll("&ecirc;","ê");
		//in hoa
		str = str.replaceAll("&Eacute;","É");
		str = str.replaceAll("&Egrave;","È");
		str = str.replaceAll("&Ecirc;","Ê");
		//Chữ u và dấu
		str = str.replaceAll("&uacute;","ú");
		str = str.replaceAll("&ugrave;","ù");
		//in hoa
		str = str.replaceAll("&Uacute;","Ú");
		str = str.replaceAll("&Ugrave;","Ù");
		//Chữ i và dấu
		str = str.replaceAll("&iacute;","í");
		str = str.replaceAll("&igrave;","ì");
		//in hoa
		str = str.replaceAll("&Iacute;","Í");
		str = str.replaceAll("&Igrave;","Ì");
		
		return str;
	}
}
