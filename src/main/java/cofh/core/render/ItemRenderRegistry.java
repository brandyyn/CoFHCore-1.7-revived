package cofh.core.render;

import cofh.lib.util.ItemWrapper;

import gnu.trove.map.hash.THashMap;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderRegistry {

	public static Map<ItemWrapper, IItemRenderer> itemRenders = new THashMap<ItemWrapper, IItemRenderer>();

	public static boolean addItemRenderer(ItemStack stack, IItemRenderer renderer) {

		if (validItem(stack)) {
			return false;
		}
		itemRenders.put(ItemWrapper.fromItemStack(stack), renderer);
		return true;
	}

	public static IItemRenderer getItemRenderer(ItemStack stack) {

		return itemRenders.get(ItemWrapper.fromItemStack(stack));
	}

	public static boolean validItem(ItemStack stack) {

		return itemRenders.containsKey(ItemWrapper.fromItemStack(stack));
	}

	public static synchronized void refreshMap() {

		Map<ItemWrapper, IItemRenderer> tempMap = new THashMap<ItemWrapper, IItemRenderer>(itemRenders.size());

		for (Entry<ItemWrapper, IItemRenderer> entry : itemRenders.entrySet()) {
			ItemWrapper tempItem = new ItemWrapper(entry.getKey().item, entry.getKey().metadata);
			tempMap.put(tempItem, entry.getValue());
		}
		itemRenders.clear();
		itemRenders = tempMap;
	}

}
