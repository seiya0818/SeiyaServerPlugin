package jp.seiya0818.SeiyaServerPlugin;

import jp.seiya0818.SeiyaServerPlugin.GameMode.GameModeCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	public static String Prefix = ChatColor.WHITE + "[" + ChatColor.RED + "" + ChatColor.BOLD + "SeiyaServerPlugin" + ChatColor.WHITE + "]";
	public static boolean debug;

	@Override
	public void onEnable()
	{
		saveDefaultConfig();
		debug = getConfig().getBoolean("Debug");

		getCommand("gm").setExecutor(new GameModeCommands(this));
		getCommand("gms").setExecutor(new GameModeCommands(this));
		getCommand("gmc").setExecutor(new GameModeCommands(this));
		getCommand("gma").setExecutor(new GameModeCommands(this));
		getCommand("gmsp").setExecutor(new GameModeCommands(this));
		getCommand("gm0").setExecutor(new GameModeCommands(this));
		getCommand("gm1").setExecutor(new GameModeCommands(this));
		getCommand("gm2").setExecutor(new GameModeCommands(this));
		getCommand("gm3").setExecutor(new GameModeCommands(this));
		getCommand("seiyaserver").setExecutor(new OtherCommands(this));
		getCommand("broadcast").setExecutor(new OtherCommands(this));
		getCommand("broadcast").setExecutor(new OtherCommands(this));
		getCommand("whoisps").setExecutor(new OtherCommands(this));

		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.GREEN  + "プラグインが読み込まれました。");
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.YELLOW  + "使用中のバージョン: " + this.getDescription().getVersion().toString());
	}

	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(Prefix + ChatColor.GREEN  + "プラグインが終了しました。");
	}

	public FileConfiguration getConfig()
	{
		return getConfig();
	}
}
