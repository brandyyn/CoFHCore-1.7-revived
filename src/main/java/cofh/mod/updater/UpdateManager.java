package cofh.mod.updater;

import static net.minecraft.util.EnumChatFormatting.*;

import cofh.core.CoFHProps;
import com.google.common.base.Strings;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public final class UpdateManager {

	private static transient int pollOffset = 0;
	private static final ChatStyle description = new ChatStyle();
	private static final ChatStyle version = new ChatStyle();
	private static final ChatStyle modname = new ChatStyle();
	private static final ChatStyle download = new ChatStyle();
	private static final ChatStyle white = new ChatStyle();
	static {
	}

	public static void registerUpdater(UpdateManager manager) {
	}

	private boolean _notificationDisplayed;
	private final IUpdatableMod _mod;
	private final UpdateCheckThread _updateThread;
	private final String _downloadUrl;
	private int lastPoll = 400;

	public UpdateManager(IUpdatableMod mod) {

		this(mod, null);
	}

	public UpdateManager(IUpdatableMod mod, String releaseUrl) {

		this(mod, releaseUrl, null);
	}

	public UpdateManager(IUpdatableMod mod, String releaseUrl, String downloadUrl) {

		_mod = mod;
		_updateThread = new UpdateCheckThread(mod, releaseUrl, downloadUrl);
		_updateThread.start();
		_downloadUrl = downloadUrl;
		lastPoll += (pollOffset += 140);
	}

	@SubscribeEvent
	public void tickStart(PlayerTickEvent evt) {
	}

}
