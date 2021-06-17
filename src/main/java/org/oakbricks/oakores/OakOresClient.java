package org.oakbricks.oakores;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.oakbricks.oakores.config.ModConfig;
import net.minecraft.entity.player.PlayerEntity;

import static net.minecraft.server.command.CommandManager.literal;
import static org.oakbricks.oakores.OakOres.CONFIG;

public class OakOresClient implements ClientModInitializer {

    MinecraftClient mc = MinecraftClient.getInstance();


    @Override
    public void onInitializeClient() {


    }

}
