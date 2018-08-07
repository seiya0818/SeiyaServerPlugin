package jp.seiya0818.SeiyaServerPlugin.GameMode;

import jp.seiya0818.SeiyaServerPlugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommands implements CommandExecutor
{

	public final Main plugin;

	public GameModeCommands(Main plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		switch(args.length)
		{
		case 0:
			if(cmd.getName().equalsIgnoreCase("gm"))
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行可能です");
				}
				else if(!sender.hasPermission("seiyaserver.staff"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					Player player = (Player) sender;
					if(player.getGameMode().equals(GameMode.CREATIVE))
					{
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをサバイバルモードに変更しました");
					}
					else
					{
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをクリエイティブモードに変更しました");
					}
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("gm0") || cmd.getName().equalsIgnoreCase("gms"))
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行可能です");
				}
				else if(!sender.hasPermission("seiyaserver.staff"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					Player player = (Player) sender;
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをサバイバルモードに変更しました");
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("gm1") || cmd.getName().equalsIgnoreCase("gmc"))
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行可能です");
				}
				else if(!sender.hasPermission("seiyaserver.staff"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					Player player = (Player) sender;
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをクリエイティブモードに変更しました");
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("gm2") || cmd.getName().equalsIgnoreCase("gma"))
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行可能です");
				}
				else if(!sender.hasPermission("seiyaserver.staff"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					Player player = (Player) sender;
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをアドベンチャーモードに変更しました");
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("gm3") || cmd.getName().equalsIgnoreCase("gmsp"))
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "このコマンドはプレイヤーのみが実行可能です");
				}
				else if(!sender.hasPermission("seiyaserver.staff"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					Player player = (Player) sender;
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをスペクターモードに変更しました");
				}
				return true;
			}
			else
			{
				sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
				return true;
			}
		case 1:
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(target != null)
			{
				if(cmd.getName().equalsIgnoreCase("gm"))
				{
					if(!sender.hasPermission("seiyaserver.admin"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						if(target.getGameMode().equals(GameMode.CREATIVE))
						{
							target.setGameMode(GameMode.SURVIVAL);
							target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをサバイバルモードに変更しました");
							sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをサバイバルモードに変更しました");
						}
						else
						{
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをクリエイティブモードに変更しました");
							sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをクリエイティブモードに変更しました");
						}
					}
					return true;
				}
				else if(cmd.getName().equalsIgnoreCase("gm0") || cmd.getName().equalsIgnoreCase("gms"))
				{
					if(!sender.hasPermission("seiyaserver.admin"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをサバイバルモードに変更しました");
						sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをサバイバルモードに変更しました");
					}
					return true;
				}
				else if(cmd.getName().equalsIgnoreCase("gm1") || cmd.getName().equalsIgnoreCase("gmc"))
				{
					if(!sender.hasPermission("seiyaserver.admin"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをクリエイティブモードに変更しました");
						sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをクリエイティブモードに変更しました");
					}
					return true;
				}
				else if(cmd.getName().equalsIgnoreCase("gm2") || cmd.getName().equalsIgnoreCase("gma"))
				{
					if(!sender.hasPermission("seiyaserver.admin"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						target.setGameMode(GameMode.ADVENTURE);
						target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをアドベンチャーモードに変更しました");
						sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをアドベンチャーモードに変更しました");
					}
					return true;
				}
				else if(cmd.getName().equalsIgnoreCase("gm3") || cmd.getName().equalsIgnoreCase("gmsp"))
				{
					if(!sender.hasPermission("seiyaserver.admin"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						target.setGameMode(GameMode.SPECTATOR);
						target.sendMessage(Main.Prefix + ChatColor.GOLD + "ゲームモードをスペクターモードに変更しました");
						sender.sendMessage(Main.Prefix + ChatColor.YELLOW + target.getName() + ChatColor.GOLD + "のゲームモードをスペクターモードに変更しました");
					}
					return true;
				}
				else
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
					return true;
				}
			}
			else
			{
				sender.sendMessage(Main.Prefix + ChatColor.RED + "指定されたプレイヤーが見つかりませんでした");
			}
		default:
			sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
			return true;
		}
	}
}
