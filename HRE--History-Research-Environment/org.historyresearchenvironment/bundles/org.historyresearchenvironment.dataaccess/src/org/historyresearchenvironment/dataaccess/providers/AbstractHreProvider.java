package org.historyresearchenvironment.dataaccess.providers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.historyresearchenvironment.dataaccess.HreH2ConnectionPool;

/**
 * Abstract superclass for HRE provider classes.
 * 
 * @version 2018-07-23
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2018
 *
 */
public abstract class AbstractHreProvider {
	@Inject
	protected static IEventBroker eventBroker;

	protected final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.historyresearchenvironment");
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected String key;

	/**
	 * No arg c:tor
	 */
	public AbstractHreProvider() {
		super();
		try {
			conn = HreH2ConnectionPool.getConnection();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	// /**
	// * @param c
	// * @param type
	// * @param model
	// * @param jsonObject
	// * @param field
	// * @throws JSONException
	// * @throws IllegalAccessException
	// * @throws InvocationTargetException
	// */
	// private static void getObjectsFromJson(Class<?> c, String type, Object model,
	// JSONObject jsonObject, Field field)
	// throws JSONException, IllegalAccessException, InvocationTargetException {
	// for (final Method method : c.getMethods()) {
	//
	// if ((method.getName().startsWith("set")) && (method.getName().length() ==
	// (field.getName().length() + 3))) {
	// if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
	// if (type.equals("int")) {
	// final int value = jsonObject.getInt(field.getName());
	// method.invoke(model, value);
	// } else {
	// final String value = jsonObject.getString(field.getName());
	// method.invoke(model, value);
	// }
	// break;
	// }
	// }
	// }
	// }

	// /**
	// * @param model
	// * @param arglist
	// * @param method
	// * @throws IllegalAccessException
	// * @throws InvocationTargetException
	// */
	// private static void invokeVararg(Object model, List<Object> arglist, Method
	// method)
	// throws IllegalAccessException, InvocationTargetException, Exception {
	// switch (arglist.size()) {
	// case 0:
	// method.invoke(model);
	// break;
	// case 1:
	// method.invoke(model, arglist.get(0));
	// break;
	// case 2:
	// method.invoke(model, arglist.get(0), arglist.get(1));
	// break;
	// case 3:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2));
	// break;
	// case 4:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3));
	// break;
	// case 5:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4));
	// break;
	// case 6:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4),
	// arglist.get(5));
	// break;
	// case 7:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4),
	// arglist.get(5), arglist.get(6));
	// break;
	// case 8:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4),
	// arglist.get(5), arglist.get(6), arglist.get(7));
	// break;
	// case 9:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4),
	// arglist.get(5), arglist.get(6), arglist.get(7), arglist.get(8));
	// break;
	// case 10:
	// method.invoke(model, arglist.get(0), arglist.get(1), arglist.get(2),
	// arglist.get(3), arglist.get(4),
	// arglist.get(5), arglist.get(6), arglist.get(7), arglist.get(8),
	// arglist.get(9));
	// break;
	// default:
	// LOGGER.severe("Too many arguments for implementation");
	// throw new Exception("Too many arguments for implementation");
	// }
	// }

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 
	 */
	public abstract void readFromDatabase();

	/**
	 * @param i
	 */
	public abstract void readFromDatabase(int i);

	// /**
	// * @param jsonstring
	// */
	// public void readJson(String jsonstring) {
	// Class<?> modelClass = null, itemClass;
	// String modelType = "";
	// String itemType = "";
	// Object model, itemObject;
	// Field[] modelFields, itemFields;
	// Field modelField = null;
	// Field itemField = null;
	// String key = "";
	// Vector<Object> argVector;
	// JSONObject jsonObject;
	//
	// try {
	// modelClass = this.getClass();
	// model = this;
	// modelFields = modelClass.getDeclaredFields();
	//
	// jsonObject = new JSONObject(jsonstring);
	//
	// for (final Field modelField2 : modelFields) {
	// modelField = modelField2;
	// modelField.setAccessible(true);
	// modelType = modelField.getType().toString();
	//
	// if (modelType.contains("java.util.Vector")) {
	// final JSONArray itemJsonArray =
	// jsonObject.getJSONArray(modelField.getName());
	// JSONObject itemJsonObject = null;
	//
	// final String genericType = modelField.getGenericType().getTypeName();
	// final String a[] = genericType.split("<");
	// final String b[] = a[1].split(">");
	// final String itemClassName = b[0];
	//
	// itemClass = Class.forName(itemClassName);
	// itemObject = itemClass.newInstance();
	// itemFields = itemClass.getDeclaredFields();
	//
	// // For each JSONObject in the JSON Array
	// for (int j = 0; j < itemJsonArray.length(); j++) {
	// itemJsonObject = itemJsonArray.getJSONObject(j);
	//
	// for (final Field itemField2 : itemFields) {
	// itemField = itemField2;
	// itemField.setAccessible(true);
	// itemType = itemField.getType().toString();
	//
	// getObjectsFromJson(itemClass, itemType, itemObject, itemJsonObject,
	// itemField);
	// }
	//
	// argVector = new Vector<Object>();
	//
	// for (final Method method : modelClass.getMethods()) {
	// if ((method.getName().startsWith("add") &&
	// (modelField.getName().toLowerCase()
	// .startsWith(method.getName().toLowerCase().substring(3))))) {
	// itemFields = itemClass.getDeclaredFields();
	//
	// for (final Field itemField2 : itemFields) {
	// itemField = itemField2;
	// itemField.setAccessible(true);
	//
	// for (final Iterator<?> iterator = itemJsonObject.keys(); iterator.hasNext();)
	// {
	// key = (String) iterator.next();
	//
	// if (itemField.getName().equals(key)) {
	// itemType = itemField.getType().toString();
	//
	// if (itemType.equals("int")) {
	// argVector.add(itemJsonObject.getInt(key));
	// } else {
	// argVector.add(itemJsonObject.getString(key));
	// }
	// break;
	// }
	// }
	// }
	//
	// try {
	// invokeVararg(model, argVector, method);
	// } catch (final Exception e) {
	// e.printStackTrace();
	// LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line "
	// + e.getStackTrace()[0].getLineNumber());
	// }
	// break;
	// }
	// }
	// }
	// } else if (modelType.contains("Vector")) {
	// LOGGER.fine("Not handling type " + modelType);
	// } else {
	// getObjectsFromJson(modelClass, modelType, model, jsonObject, modelField);
	// }
	// }
	// } catch (final Exception e) {
	// e.printStackTrace();
	// LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line " +
	// e.getStackTrace()[0].getLineNumber());
	// }
	// }

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	// /**
	// * @param classname
	// * @return
	// */
	// public String writeJson() {
	// Class<?> c;
	// Field field;
	// String type;
	// String key;
	// String value;
	// Class<?> c1;
	// Field field1;
	// String key1;
	// String value1;
	// final StringWriter sw = new StringWriter();
	//
	// LOGGER.info("Abstract HRE Provider invoked");
	//
	// String classname = this.getClass().getName();
	//
	// LOGGER.fine("Class name: " + classname);
	//
	// try {
	// c = Class.forName(classname);
	// final Field[] fa = c.getDeclaredFields();
	//
	// final JSONWriter jw = new JSONWriter(sw);
	// jw.object();
	//
	// // Each field
	// for (final Field element : fa) {
	// field = element;
	//
	// type = field.getType().toString();
	//
	// if (type.contains("[[[")) {
	// throw new Exception("Too many array levels for this implementation");
	// }
	//
	// if (type.contains("[[")) {
	// throw new Exception("Too many array levels for this implementation, so far");
	// }
	//
	// // Primary type array
	// if (type.contains("[")) {
	// key = field.getName();
	// jw.key(key);
	//
	// jw.array();
	//
	// // Integer array
	// if (type.contains("[I")) {
	// final int[] valueArray = (int[]) field.get(this);
	//
	// for (int j = 0; j < valueArray.length; j++) {
	// jw.object();
	// jw.key(key + "[" + j + "]");
	// jw.value(Integer.toString(valueArray[j]));
	// jw.endObject();
	// }
	//
	// // String Array
	// } else {
	// final String[] valueArray = (String[]) field.get(this);
	//
	// for (int j = 0; j < valueArray.length; j++) {
	// LOGGER.info(valueArray[j]);
	// jw.object();
	// jw.key(key + "[" + j + "]");
	// jw.value(valueArray[j]);
	// jw.endObject();
	// }
	// }
	//
	// jw.endArray();
	//
	// // Component array
	// } else if (type.contains("java.util.Vector")) {
	// final Vector<?> v = (Vector<?>) field.get(this);
	//
	// key = field.getName();
	// jw.key(key);
	//
	// jw.array();
	//
	// for (final Object name : v) {
	// jw.object();
	// final AbstractHreModel item = (AbstractHreModel) name;
	// c1 = item.getClass();
	// final Field[] fa1 = c1.getDeclaredFields();
	//
	// for (final Field element2 : fa1) {
	// field1 = element2;
	// key1 = field1.getName();
	// jw.key(key1);
	//
	// if (field1.getType().getName().equals("int")) {
	// value1 = Integer.toString(field1.getInt(item));
	// } else {
	// value1 = (String) field1.get(item);
	// }
	// jw.value(value1);
	// }
	//
	// jw.endObject();
	// }
	//
	// jw.endArray();
	//
	// // Non-array
	// } else if (type.contains("Vector")) {
	// // Ignore
	// } else {
	// key = field.getName();
	// jw.key(key);
	//
	// // Integer
	// if (type.equals("int")) {
	// value = Integer.toString((int) field.get(this));
	//
	// // String
	// } else {
	// value = (String) field.get(this);
	//
	// }
	// jw.value(value);
	// }
	// }
	// jw.endObject();
	// } catch (final Exception e) {
	// LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line " +
	// e.getStackTrace()[0].getLineNumber());
	// }
	// LOGGER.info(sw.toString());
	// return sw.toString();
	// }
}