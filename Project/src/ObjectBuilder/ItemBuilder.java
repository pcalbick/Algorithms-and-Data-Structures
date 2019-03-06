package ObjectBuilder;

public interface ItemBuilder {
	Item build();
	ItemBuilder set(final String s);
}
