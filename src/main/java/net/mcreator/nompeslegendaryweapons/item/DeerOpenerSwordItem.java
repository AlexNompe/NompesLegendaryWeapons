
package net.mcreator.nompeslegendaryweapons.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.nompeslegendaryweapons.procedures.DeerOpenerSwordSpecialProcedure;
import net.mcreator.nompeslegendaryweapons.itemgroup.NompesLegendaryWeaponsTabItemGroup;
import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@NompesLegendaryWeaponsModElements.ModElement.Tag
public class DeerOpenerSwordItem extends NompesLegendaryWeaponsModElements.ModElement {
	@ObjectHolder("nompes_legendary_weapons:deer_opener_sword")
	public static final Item block = null;

	public DeerOpenerSwordItem(NompesLegendaryWeaponsModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 5000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BlackSteelItem.block));
			}
		}, 3, -2.4f, new Item.Properties().group(NompesLegendaryWeaponsTabItemGroup.tab).isImmuneToFire()) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DeerOpenerSwordSpecialProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("itemstack", itemstack))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("deer_opener_sword"));
	}
}
