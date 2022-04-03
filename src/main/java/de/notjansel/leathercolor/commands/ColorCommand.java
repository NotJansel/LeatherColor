package de.notjansel.leathercolor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;

public class ColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§c/color <color>");
            player.sendMessage("§cExample: §6/color #4A14B7");
            player.sendMessage("§cColors have to be in hexformat!");
            return true;
        }
        if (args.length == 1) {
            if (args[0].length() != 7) {
                player.sendMessage("§cColor has to be in hexformat!");
                return true;
            }
            if (!args[0].startsWith("#")) {
                player.sendMessage("§cColor has to be in hexformat!");
                return true;
            }
            if (!args[0].matches("#[0-9a-fA-F]{6}")) {
                player.sendMessage("§cColor has to be in hexformat!");
                return true;
            }
            if (player.getItemInHand().getType().name().contains("LEATHER") && (player.getItemInHand().getType().name().contains("_CHESTPLATE") || player.getItemInHand().getType().name().contains("_HELMET") || player.getItemInHand().getType().name().contains("_BOOTS") || player.getItemInHand().getType().name().contains("_LEGGINGS") || player.getItemInHand().getType().name().contains("_HORSE"))) {
                ItemMeta meta = player.getItemInHand().getItemMeta();
                LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
                leatherArmorMeta.setColor(org.bukkit.Color.fromRGB(Integer.parseInt(args[0].substring(1), 16)));
                player.getItemInHand().setItemMeta(leatherArmorMeta);
                player.sendMessage("§aColor set!");

            } else {
                player.sendMessage("§cYou can only use this command on leather armor!");
            }
        }
        return true;
    }
}
