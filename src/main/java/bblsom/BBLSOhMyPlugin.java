package bblsom;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import fermiumbooter.FermiumRegistryAPI;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class BBLSOhMyPlugin implements IFMLLoadingPlugin {
	
	public BBLSOhMyPlugin() {
		MixinBootstrap.init();
		MixinExtrasBootstrap.init();
		FermiumRegistryAPI.enqueueMixin(false, "mixins.bblsom.vanilla.json");
	}
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}
	
	@Override
	public String getModContainerClass() {
		return null;
	}
	
	@Override
	public String getSetupClass() {
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) {
	
	}
	
	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}