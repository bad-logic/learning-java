package pdfgenerator.templates;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The interface Pdf template component.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PdfTemplateComponent {

	/**
	 * Name string.
	 *
	 * @return the string
	 */
	String name();

	/**
	 * Singleton boolean.
	 *
	 * @return the boolean
	 */
	boolean singleton() default false;

}
