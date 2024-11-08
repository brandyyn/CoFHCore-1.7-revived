package cofh.mod.updater;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.nbt.NBTTagCompound;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.AbstractLogger;

public class UpdateCheckThread extends Thread {


	private boolean _checkComplete = false;
	private boolean _newVerAvailable = false;
	private boolean _criticalUpdate = false;
	private ModVersion _newVer;

	public UpdateCheckThread(IUpdatableMod mod) {

		this(mod, null);
	}

	public UpdateCheckThread(IUpdatableMod mod, String releaseUrl) {

		this(mod, null, null);
	}

	public UpdateCheckThread(IUpdatableMod mod, String releaseUrl, String downloadUrl) {
	}

	@Override
	public void run() {
	}

	public boolean checkComplete() {

		return _checkComplete;
	}

	public boolean isCriticalUpdate() {

		return _criticalUpdate;
	}

	public boolean newVersionAvailable() {

		return _newVerAvailable;
	}

	public ModVersion newVersion() {

		return _newVer;
	}

}
