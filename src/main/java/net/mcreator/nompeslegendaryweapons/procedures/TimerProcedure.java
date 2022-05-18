package net.mcreator.nompeslegendaryweapons.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsModVariables;
import net.mcreator.nompeslegendaryweapons.NompesLegendaryWeaponsMod;

import java.util.Map;
import java.util.HashMap;

public class TimerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NompesLegendaryWeaponsMod.LOGGER.warn("Failed to load dependency entity for procedure Timer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NompesLegendaryWeaponsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NompesLegendaryWeaponsModVariables.PlayerVariables())).timer < 0) {
			{
				double _setval = ((entity.getCapability(NompesLegendaryWeaponsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NompesLegendaryWeaponsModVariables.PlayerVariables())).timer - 1 / 20);
				entity.getCapability(NompesLegendaryWeaponsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(NompesLegendaryWeaponsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
