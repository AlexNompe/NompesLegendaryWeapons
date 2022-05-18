
package net.mcreator.nompeslegendaryweapons.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.nompeslegendaryweapons.itemgroup.NompesLegendaryWeaponsTabItemGroup;
import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsModElements;

@NompesLegendaryWeaponsModElements.ModElement.Tag
public class StarSparkItem extends NompesLegendaryWeaponsModElements.ModElement {
	@ObjectHolder("nompes_legendary_weapons:star_spark")
	public static final Item block = null;

	public StarSparkItem(NompesLegendaryWeaponsModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NompesLegendaryWeaponsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("star_spark");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
