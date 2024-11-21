package bblsom.handlers;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import bblsom.BBLSOhMy;

@Config(modid = BBLSOhMy.MODID)
public class ForgeConfigHandler {
	
	@Config.Comment("Server-Side Options")
	@Config.Name("Server Options")
	public static final ServerConfig server = new ServerConfig();

	public static class ServerConfig {

		@Config.Comment(
				"Custom Buttons to be registered" + "\n" +
				"Format: String name, Boolean wooden, int tickrate" + "\n" +
				"String name: the name of the item/block to be registered" + "\n" +
				"Boolean wooden: whether the button should be treated as wooden or not (Affects sound and tickrate)" + "\n" +
				"int tickrate: tickrate override for the button, if left as 0 uses the vanilla handling based on wooden or not")
		@Config.Name("Custom Button Entries")
		@Config.RequiresMcRestart
		public String[] customButtons = {""};
		
		@Config.Comment(
				"Custom Levers to be registered" + "\n" +
						"Format: String name" + "\n" +
						"String name: the name of the item/block to be registered")
		@Config.Name("Custom Lever Entries")
		@Config.RequiresMcRestart
		public String[] customLevers = {""};
		
		@Config.Comment(
				"Custom Signs to be registered" + "\n" +
						"Format: String name" + "\n" +
						"String name: the name of the item/block to be registered")
		@Config.Name("Custom Sign Entries")
		@Config.RequiresMcRestart
		public String[] customSigns = {""};
		
		@Config.Comment(
				"Custom Boats to be registered" + "\n" +
						"Format: String name, ItemID plankItem, int plankMeta, ItemID stickItem, int stickMeta" + "\n" +
						"String name: the name of the item/boat to be registered" + "\n" +
						"ItemID plankItem: The item id of the plank-like item to be dropped when the boat is broken dangerously" + "\n" +
						"int plankMeta: The metadata of the plank-like item to be dropped when the boat is broken dangerously" + "\n" +
						"ItemID stickItem: The item id of the stick-like item to be dropped when the boat is broken dangerously" + "\n" +
						"int stickMeta: The metadata of the stick-like item to be dropped when the boat is broken dangerously")
		@Config.Name("Custom Boat Entries")
		@Config.RequiresMcRestart
		public String[] customBoats = {""};
		
		@Config.Comment(
				"Custom Horse Armors to be registered" + "\n" +
						"Format: String name, int armorStrength" + "\n" +
						"String name: the name of the armor to be registered" + "\n" +
						"int armorStrength: the strength of the armor to be registered")
		@Config.Name("Custom Horse Armor Entries")
		@Config.RequiresMcRestart
		public String[] customHorseArmors = {""};
		
		@Config.Comment("Whether or not to register a backported honey block")
		@Config.Name("Register Honey Block")
		@Config.RequiresMcRestart
		public boolean registerHoneyBlock = true;
	}

	@Mod.EventBusSubscriber(modid = BBLSOhMy.MODID)
	private static class EventHandler{

		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if(event.getModID().equals(BBLSOhMy.MODID)) {
				ConfigManager.sync(BBLSOhMy.MODID, Config.Type.INSTANCE);
			}
		}
	}
}