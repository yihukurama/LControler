package com.yihukurama.lcontroler.control.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	// 判断手机格式是否正确
	public static boolean isMobileNO(String mobiles) {
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Pattern p = Pattern.compile("^((13[0-9])|(14[57])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);

		return m.matches();
	}

	// 判断email格式是否正确
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);

		return m.matches();
	}
	
	//判断是否符合积分使用格式
	public static boolean isRightIntegal(String integral) {
		String str = "^(([0-9]\\d*)|([0-9]+.[0-9]{1,2}))$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(integral);

		return m.matches();
	}
	/**
	 * 判断是否为纯数字.
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();    
	}
	 /**
     * 判断是否为中文.
     * @param name
     * @return
     */
    public static boolean isChinese(String name){
		String chinese  = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$"; /**这个正则表达式用来判断是否为中文**/
		Pattern pattern = Pattern.compile(chinese);
		boolean tf = pattern.matcher(name).matches();
		return tf;
	}
    /**
     * 判断单词字符是否为数字或字母：[a-z A-Z 0-9]
     * @param name
     * @return
     */
    public static boolean isNumOrLetter(String name){
		String username   = "^\\w+$";   /**此正则表达式判断单词字符是否为：[a-zA-Z_0-9]**/
		Pattern pattern = Pattern.compile(username);
		boolean tf = pattern.matcher(name).matches();
		return tf;
	}
    
    /**
     * 判断中文、大小写字母和数字，{a，b}字符的长度为a-b
     * @param name
     * @return
     */
    public static boolean isAllCharacter(String name,int a,int b){
    	String all  = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]{"+a+","+b+"}$";  /**此正则表达式将上面二者结合起来进行判断，中文、大小写字母和数字，{2，10}字符的长度为2-10**/
		Pattern pattern = Pattern.compile(all);
		boolean tf = pattern.matcher(name).matches();
		return tf;
	}
    
    /**
     * 验证是否为可以的数字
     * 非负浮点数（正浮点数 + 0）：^\d+(\.\d+)?$
     */
    public static boolean isTrueNumber(CharSequence str) {
    	String num = "^\\d+(\\.\\d+)?$";
		Pattern p = Pattern.compile(num);
		Matcher m = p.matcher(str);
		return m.matches();
    }
	/**
	 * 限定输入框只能输入到小数点后两位
	 * @param editText
	 */
	public static void setPricePoint(final EditText editText) {
		editText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.toString().contains(".")) {
					if (s.length() - 1 - s.toString().indexOf(".") > 2) {
						s = s.toString().subSequence(0,
								s.toString().indexOf(".") + 3);
						editText.setText(s);
						editText.setSelection(s.length());
					}
				}
				if (s.toString().trim().substring(0).equals(".")) {
					s = "0" + s;
					editText.setText(s);
					editText.setSelection(2);
				}

				if (s.toString().startsWith("0")
						&& s.toString().trim().length() > 1) {
					if (!s.toString().substring(1, 2).equals(".")) {
						editText.setText(s.subSequence(0, 1));
						editText.setSelection(1);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

		});

	}

	/**
	 * 转义正则特殊字符 （$()*+.[]?\^{},|）
	 *
	 * @param keyword
	 * @return
	 */
	public static String escapeExprSpecialWord(String keyword) {
		if (keyword!=null && !keyword.equals("")) {
			try {
//				String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|", "'"};
				String[] fbsArr ={"'"};
 				for (String key : fbsArr) {
					if (keyword.contains(key)) {
						keyword = keyword.replace(key, "&#39");
					}
				}
			}catch (Exception e){};
		}
		return keyword;
	}
}
