
package net.mcreator.nompeslegendaryweapons.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nompeslegendaryweapons.item.BlackSteelItem;
import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsModElements;

@NompesLegendaryWeaponsModElements.ModElement.Tag
public class NompesLegendaryWeaponsTabItemGroup extends NompesLegendaryWeaponsModElements.ModElement {
	public NompesLegendaryWeaponsTabItemGroup(NompesLegendaryWeaponsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnompes_legendary_weapons_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlackSteelItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
