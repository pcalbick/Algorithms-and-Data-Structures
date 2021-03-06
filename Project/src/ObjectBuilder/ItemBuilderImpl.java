package ObjectBuilder;

public class ItemBuilderImpl implements ItemBuilder {
	private Item tempItem;
	
	public ItemBuilderImpl() {
		tempItem = new Item();
	}
	
	@Override
	public Item build() {
		Item item = new Item();
		item.set(tempItem.get());
		return item;
	}
	
	@Override
	public ItemBuilder set(final String s) {
		tempItem.set(s);
		return this;
	}
}
