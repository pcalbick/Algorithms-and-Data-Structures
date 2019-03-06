package ObjectBuilder;

public class Client {

	public static void main(String[] args) {
		ItemBuilder builder = new ItemBuilderImpl();
		Item item = builder.set(args[0])
							.build();
		System.out.println(item.get());
	}

}
