
package net.mcreator.nompeslegendaryweapons.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.nompeslegendaryweapons.itemgroup.NompesLegendaryWeaponsTabItemGroup;
import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsModElements;

@NompesLegendaryWeaponsModElements.ModElement.Tag
public class BlackSteelItem extends NompesLegendaryWeaponsModElements.ModElement {
	@ObjectHolder("nompes_legendary_weapons:black_steel")
	public static final Item block = null;

	public BlackSteelItem(NompesLegendaryWeaponsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NompesLegendaryWeaponsTabItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("black_steel");
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
