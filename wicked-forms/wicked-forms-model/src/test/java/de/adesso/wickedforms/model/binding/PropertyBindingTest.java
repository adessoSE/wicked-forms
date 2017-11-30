package de.adesso.wickedforms.model.binding;


import org.junit.Assert;
import org.junit.Test;

public class PropertyBindingTest {

	@Test
	public void test() {
		Person person = new Person();
		Binding<String> nameBinding = new PropertyBinding<String>(person, "name");
		Binding<Integer> ageBinding = new PropertyBinding<Integer>(person, "age");
		nameBinding.setValue("Tom");
		ageBinding.setValue(30);

		Assert.assertEquals("Tom", person.getName());
		Assert.assertEquals(30, person.getAge());
	}

	@Test(expected = IllegalStateException.class)
	public void testWrongType() {
		Person person = new Person();
		Binding<String> nameBinding = new PropertyBinding<String>(person, "age");
		nameBinding.setValue("Tom");
	}

	public class Person {

		private String name;

		private int age;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getAge() {
			return age;
		}
	}

}
