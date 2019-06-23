package net.myerichsen.hremvp.person.providers;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.json.JSONWriter;

import com.opcoach.e4.preferences.ScopedPreferenceStore;

import net.myerichsen.hremvp.HreH2ConnectionPool;
import net.myerichsen.hremvp.MvpException;

/**
 * @author Michael Erichsen, &copy; History Research Environment Ltd., 2019
 * @version 11. apr. 2019
 *
 */
public abstract class AbstractHreProvider {
	@Inject
	protected static IEventBroker eventBroker;
	protected static final Logger LOGGER = Logger.getLogger("global");
	protected ScopedPreferenceStore store = new ScopedPreferenceStore(
			InstanceScope.INSTANCE, "org.historyresearchenvironment.usergui");
	protected Connection conn = null;

	protected PreparedStatement pst = null;

	protected String key;

	/**
	 * Constructor
	 *
	 */
	public AbstractHreProvider() {
		try {
			conn = HreH2ConnectionPool.getConnection();
		} catch (final Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}

	/**
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param paramInt
	 */
	public abstract void readFromH2(int paramInt);

//	public void readJson(String jsonstring) {
//		 Class<?> modelClass = null;
//		 String modelType = "";
//		 String itemType = "";
//
//		 Field modelField = null;
//		 Field itemField = null;
//		 String key = "";
//
//		try {
//			 modelClass = getClass();
//			 Object model = this;
//			 Field[] modelFields = modelClass.getDeclaredFields();
//
//			 JSONObject jsonObject = new JSONObject(jsonstring);
//			Field[] arrayOfField1;
//			 int j = (arrayOfField1 = modelFields).length;
//			for (int i = 0; i < j; i++) {
//				Field modelField2 = arrayOfField1[i];
//				 modelField = modelField2;
//				 modelField.setAccessible(true);
//				 modelType = modelField.getType().toString();
//
//				 if (modelType.contains("java.util.Vector")) {
//					 JSONArray itemJsonArray = jsonObject.getJSONArray(modelField.getName());
//					 JSONObject itemJsonObject = null;
//
//					 String genericType = modelField.getGenericType().getTypeName();
//					 String[] a = genericType.split("<");
//					 String[] b = a[1].split(">");
//					 String itemClassName = b[0];
//
//					 Class<?> itemClass = Class.forName(itemClassName);
//					 Object itemObject = itemClass.newInstance();
//					 Field[] itemFields = itemClass.getDeclaredFields();
//
//					 for (int j1 = 0; j1 < itemJsonArray.length(); j1++) {
//						 itemJsonObject = itemJsonArray.getJSONObject(j1);
//						Object localObject1;
//						 int m = (localObject1 = itemFields).length;
//						for (int k = 0; k < m; k++) {
//							Field itemField2 = localObject1[k];
//							 itemField = itemField2;
//							 itemField.setAccessible(true);
//							 itemType = itemField.getType().toString();
//
//							 getObjectsFromJson(itemClass, itemType, itemObject, itemJsonObject, itemField);
//						}
//
//						 Vector<Object> argVector = new Vector();
//
//						 m = (localObject1 = modelClass.getMethods()).length;
//						for (k = 0; k < m; k++) {
//							Method method = localObject1[k];
//							 if ((method.getName().startsWith("add")) &&
//							 (modelField.getName().toLowerCase()
//									.startsWith(method.getName().toLowerCase().substring(3)))) {
//								 itemFields = itemClass.getDeclaredFields();
//								Field[] arrayOfField2;
//								 int i1 = (arrayOfField2 = itemFields).length;
//								for (int n = 0; n < i1; n++) {
//									Field itemField2 = arrayOfField2[n];
//									 itemField = itemField2;
//									 itemField.setAccessible(true);
//
//									 for (Iterator<?> iterator = itemJsonObject.keys(); iterator.hasNext();) {
//										 key = (String) iterator.next();
//
//										 if (itemField.getName().equals(key)) {
//											 itemType = itemField.getType().toString();
//
//											 if (itemType.equals("int")) {
//												 argVector.add(Integer.valueOf(itemJsonObject.getInt(key)));
//												 break;
//											}
//											 argVector.add(itemJsonObject.getString(key));
//
//											 break;
//										}
//									}
//								}
//								try {
//									 invokeVararg(model, argVector, method);
//								} catch (Exception e) {
//                                   LOGGER.log(Level.SEVERE, e.toString(), e);//									 LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line " +
//								}
//							}
//						}
//					}
//				}
//				 else if (modelType.contains("Vector")) {
//					 LOGGER.log( Level.FINE, "Not handling type " + modelType);
//				} else {
//					 getObjectsFromJson(modelClass, modelType, model, jsonObject, modelField);
//				}
//			}
//		} catch (Exception e) {
//  LOGGER.log(Level.SEVERE, e.toString(), e);//									 LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line " +
//		}
//	}

	/**
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param classname
	 * @return
	 */
	public String writeJson(String classname) {
		final StringWriter sw = new StringWriter();

		LOGGER.log(Level.FINE, "Class name: {0}", classname);
		try {
			final Class<?> c = Class.forName(classname);
			final Field[] fa = c.getDeclaredFields();

			final JSONWriter jw = new JSONWriter(sw);
			jw.object();

			final Field[] arrayOfField1 = fa;
			final int j = arrayOfField1.length;
			for (int i = 0; i < j; i++) {
				final Field element = arrayOfField1[i];
				final Field field = element;

				final String type = field.getType().toString();

				if (type.contains("[[[")) {
					throw new MvpException(
							"Too many array levels for this implementation");
				}

				if (type.contains("[[")) {
					throw new MvpException(
							"Too many array levels for this implementation, so far");
				}

				if (type.contains("[")) {
					final String fieldName = field.getName();
					jw.key(fieldName);

					jw.array();

					if (type.contains("[I")) {
						final int[] valueArray = (int[]) field.get(this);

						for (int j1 = 0; j1 < valueArray.length; j1++) {
							jw.object();
							jw.key(fieldName + "[" + j1 + "]");
							jw.value(Integer.toString(valueArray[j1]));
							jw.endObject();
						}
					} else {
						final String[] valueArray = (String[]) field.get(this);

						for (int j1 = 0; j1 < valueArray.length; j1++) {
							LOGGER.log(Level.INFO, valueArray[j1]);
							jw.object();
							jw.key(fieldName + "[" + j1 + "]");
							jw.value(valueArray[j1]);
							jw.endObject();
						}
					}

					jw.endArray();

				} else if (type.contains("java.util.Vector")) {
					final Vector<?> v = (Vector<?>) field.get(this);

					final String fieldName = field.getName();
					jw.key(fieldName);

					jw.array();

					for (final Object name : v) {
						jw.object();
						final AbstractHreModel item = (AbstractHreModel) name;
						final Class<?> c1 = item.getClass();
						final Field[] fa1 = c1.getDeclaredFields();
						final Field[] arrayOfField2 = fa1;
						final int m = arrayOfField2.length;
						for (int k = 0; k < m; k++) {
							final Field element2 = arrayOfField2[k];
							final Field field1 = element2;
							final String key1 = field1.getName();
							jw.key(key1);
							String value11;
							if (field1.getType().getName().equals("int")) {
//							if (field1 instanceof int) {
								value11 = Integer.toString(field1.getInt(item));
							} else {
								value11 = (String) field1.get(item);
							}
							jw.value(value11);
						}

						jw.endObject();
					}

					jw.endArray();

				} else if (!type.contains("Vector")) {

					final String fieldName = field.getName();
					jw.key(fieldName);
					String value1;
					if (type.equals("int")) {
						value1 = Integer.toString(
								((Integer) field.get(this)).intValue());
					} else {
						value1 = (String) field.get(this);
					}

					jw.value(value1);
				}
			}
			jw.endObject();
			LOGGER.log(Level.INFO, "{0}", sw);
		} catch (final Exception e) {
			LOGGER.severe(e.getClass() + ": " + e.getMessage() + " at line "
					+ e.getStackTrace()[0].getLineNumber());
		}

		return sw.toString();
	}
}
