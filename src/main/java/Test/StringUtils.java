package Test;

public class StringUtils {

	public static void main(String[] args) {
		String abcString="E:\\xxx\\Bolg\\src\\main\\webapp\\attached/";
	
		System.out.println(abcString.contains("webapp"));
		abcString.replace("webapp", "acd\\dcc");
		System.out.println(abcString);
	}
}
