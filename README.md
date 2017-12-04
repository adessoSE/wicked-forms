Wicked Forms
============
[![Build Status](https://travis-ci.org/adessoAG/wicked-forms.svg?branch=master)](https://travis-ci.org/adessoAG/wicked-forms)

Showcase
========
To view the showcase app, follow these steps:
* clone the repo
* run `./gradlew build` (or `gradlew.bat build` on Windows)
* drop the WAR file from the folder `wicked-forms-showcase-wicket7/build/libs` into a Tomcat's `webapp` dir (you might want to rename it to `showcase.war`)
* open `localhost:8080/<NAME_OF_THE_WAR>` in your browser

Include in Gradle build
=======================
To include wicked-forms in your Gradle build, add the following to your `build.gradle`

```
repositories {
	maven {
		url  "https://dl.bintray.com/adesso/wicked-forms"
	}
}

dependencies {
  compile "de.adesso:wicked-forms-wicket-6:1.0.0-BETA" // when using Wicket 6
  compile "de.adesso:wicked-forms-wicket-7:1.0.0-BETA" // when using Wicket 7
}
```

Why dynamic forms?
==================
Wicked Forms is a Java library you can use to create dynamic forms in your Java web applications (more specifically with Apache Wicket). A static form is a form that is defined once and cannot change it's structure whereas a dynamic form is a form that can be defined at runtime.

Use cases for dynamic forms include the following:

* **Rapid Prototyping:** if you use Java Persistence API (JPA) for your database-driven web application you could process the JPA
annotations
and create dynamic forms for each of your entities to rapidly create CRUD functionality (Create, Update, Delete). As a bonus,
you may want to add Bean Validation support to these forms. A JPA annotation processor is part of the roadmap of Wicked Forms (see issue 1 and issue 2).
* **User-Defined Forms:** any use case that requires a user to define a form to be filled out by other users is a use case for dynamic
forms.
An application where a user may create questionnaires or surveys to be filled out by other users is an example. Wicked Forms provides all form input components you might need to create questionnaires.
* **Wizards:** some forms may not need to be wholly user-defined but need to be configurable to a certain extent nonetheless. Such forms
include wizards in which the second form changes it's input fields depending on the input the user has entered in the first form.
* **Form-Based Communication Protocols:** if two applications need to exchange form-based data (i.e. structured data that has been entered
 by
a user, for example in XML), dynamic forms are needed to display this data in a form to another user in the target application. An example of this has already been implemented as a showcase for the German XVergabe standard. See http://www.wicked-forms.org/wicked-forms-showcase-xvergabe.
* **Laziness:** software developers are lazy by profession. Thus, you can let Wicked Forms create your forms for you without the hassle of
programming client-side validation, accessibility features, HTML5 input fields and CSS classes.

Planned Features of Wicked Forms
================================
* modelling of dynamic forms with pure Java
* all default input components available (text fields, radio buttons, checkboxes, ...)
* custom input components can be added
* HTML5 form elements and thus automatic client-side validation
* accessible forms
* reasonably nice default design
* overridable design (CSS, HTML)


