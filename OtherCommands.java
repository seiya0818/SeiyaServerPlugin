package jp.seiya0818.SeiyaServerPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;

public class OtherCommands implements CommandExecutor
{
	public final Main plugin;

	public OtherCommands(Main plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		switch(args.length)
		{
		case 1:
			if(cmd.getName().equalsIgnoreCase("seiyaserver"))
			{
				if(args[0].equalsIgnoreCase("frandre"))
				{
					sender.sendMessage("                                          r､");
					sender.sendMessage("                        ,. ''´￣￣ ｀'''| lヽ､／「|              ______");
					sender.sendMessage("         ______       .rﾉ ,.-､,ｨ二ゝ-､//:::､ゝ'､.|.|            /___／");
					sender.sendMessage("         ＼___＼  ,ｒ‐'7'´´       ｀ヽLi___,i   ﾊ|ゝ        ／ ______");
					sender.sendMessage("          ______ /   i,/´ i  ﾄ,  ﾊ  ,!ｨ   く:」  |  |>       //<´   ／");
					sender.sendMessage("       ／___／i'|    ｲ  ﾊヽ! V  !ｧ-t､ﾊ  .|  !  !        | |､___￣");
					sender.sendMessage("       ￣,.--ｧ| |    ﾚﾍﾊ〉,      'ヽﾘ' i  Y|    /    __,.//  ＼￣＼");
					sender.sendMessage("       ∠___／ヽヽ.,,_  !,へ､   _    ',ｲ /.|. ,ｲ    「ｒ‐''|ー-､￣￣");
					sender.sendMessage("              ／i｀'ｰ-〈rヽ./_｀ｨ7Tr´､!/､ !/ﾉ _,,.ノﾉｫ--＼___＼");
					sender.sendMessage("              |／   ／|ヽ､Y´/ム､/i´  ｀ヽｒ'-ｒ'''ｒ-＼___＼");
					sender.sendMessage("                    |／   /7:/_ﾊ」::ゝ､_ｒ-ｲ  ∧  ＼  |");
					sender.sendMessage("                        ／/::::/::::::::::::::;ﾍ    '.,-へ_ノ）｀");
					sender.sendMessage("                     ／ ,くr‐'ｰ--､:;::_」ﾆ＼  ヽ._ｰ'´");
					sender.sendMessage("    ,..､             !,.Ｊ／:::￣:::::｀'ｰ'へ    ヽ)___)");
					sender.sendMessage("    ﾉo )__,,,,....-‐''''／/:::::::::::::::::::i::::::::::｀ヽ.");
					sender.sendMessage("  <.  o r─ ''''' くi:::/::::::::::::::::__::l::::::::::::::::_>､");
					sender.sendMessage("    ヽ-'            ｀ｰ'ﾆﾍ二ｨ､二ｒ二ｒン-'´");
					sender.sendMessage("                            ｀ヽ!    /");
					sender.sendMessage("                               ri,__,/!");
					sender.sendMessage("                              /ﾍ-ﾍ!〉");
					sender.sendMessage("                              !___／");
				}
				else
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("broadcast"))
			{
				if(!sender.hasPermission("seiyaserver.moderator"))
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
				}
				else
				{
					String coloredMsg = "";
					for(int i = 0; i < args[0].length(); i++)
					{
						if(args[0].charAt(i) == '&')
						{
							coloredMsg += '§';
						}
						else
						{
							coloredMsg += args[0].charAt(i);
						}
					}
					Bukkit.broadcastMessage(coloredMsg);
				}
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("whoisps"))
			{
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target != null)
				{
					if(!sender.hasPermission("seiyaserver.staff"))
					{
						sender.sendMessage(Main.Prefix + ChatColor.RED + "権限がありません");
					}
					else
					{
						String ip = target.getAddress().getAddress().getHostAddress();

						sender.sendMessage(ChatColor.AQUA + "======== Whois Information ========");
						sender.sendMessage(ChatColor.GOLD + "名前: " + ChatColor.RESET + target.getName());
						sender.sendMessage(ChatColor.GOLD + "ニックネーム: " + ChatColor.RESET + target.getDisplayName());
						sender.sendMessage(ChatColor.GOLD + "UUID: " + ChatColor.RESET + target.getUniqueId());
						//sender.sendMessage(ChatColor.GOLD + "初回ログイン: " + ChatColor.RESET + timeStr);
						sender.sendMessage(ChatColor.GOLD + "HP: " + ChatColor.RESET + (int)target.getHealth() + "/" + (int)target.getHealthScale());
						sender.sendMessage(ChatColor.GOLD + "空腹度: " + ChatColor.RESET + target.getFoodLevel() + " (" + (int)target.getSaturation() + ")");
						sender.sendMessage(ChatColor.GOLD + "経験値: " + ChatColor.RESET + target.getTotalExperience() + " (" + "Level: " + target.getLevel() + ")");
						sender.sendMessage(ChatColor.GOLD + "座標: " + ChatColor.RESET + target.getLocation().getWorld().getName() + ", " + target.getLocation().getBlockX() + ", " + target.getLocation().getBlockY() + ", " + target.getLocation().getBlockZ());
						sender.sendMessage(ChatColor.GOLD + "ゲームモード: " + ChatColor.RESET + target.getGameMode());
						sender.sendMessage(ChatColor.GOLD + "Fly: " + ChatColor.RESET + target.getAllowFlight() + " (" + target.isFlying() + ")");
						sender.sendMessage(ChatColor.GOLD + "OP: " + ChatColor.RESET + target.isOp());
						sender.sendMessage(ChatColor.GOLD + "IP: " + ChatColor.RESET + ip);
						sender.sendMessage(ChatColor.GOLD + "ホストネーム: " + ChatColor.RESET + target.getAddress().getHostName());

						InputStream in = Main.class.getResourceAsStream("GeoLite2-City.mmdb");
						try
						{
							DatabaseReader cityDB = new DatabaseReader.Builder(in).build();
							CityResponse response = cityDB.city(InetAddress.getByName(ip));
							Country country = response.getCountry();
							City city = response.getCity();
							sender.sendMessage(ChatColor.GOLD + "接続国名: " + ChatColor.RESET + country.getNames().get("jp") + " (" + country.getName() + ")");
							sender.sendMessage(ChatColor.GOLD + "接続都市名: " + ChatColor.RESET + city.getNames().get("jp") + " (" + city.getName() + ")");
							sender.sendMessage("※興味本位で都市名表示機能を追加しました。正確とは限らないので注意。");
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
						catch(GeoIp2Exception e)
						{
							e.printStackTrace();
						}
					}
				}
				else
				{
					sender.sendMessage(Main.Prefix + ChatColor.RED + "指定されたプレイヤーが見つかりませんでした");
				}
			}
			else
			{
				sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
				return true;
			}
		default:
			sender.sendMessage(Main.Prefix + ChatColor.RED + "コマンドの使用方法を確認してください");
			return true;
		}
	}
}