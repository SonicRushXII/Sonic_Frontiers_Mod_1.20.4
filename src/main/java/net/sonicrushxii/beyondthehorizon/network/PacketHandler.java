package net.sonicrushxii.beyondthehorizon.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;
import net.sonicrushxii.beyondthehorizon.BeyondTheHorizon;
import net.sonicrushxii.beyondthehorizon.network.baseform.passives.doublejump.*;
import net.sonicrushxii.beyondthehorizon.network.sync.*;

public class PacketHandler {
    private static final int PROTOCOL_VERSION = 1;
    private static final SimpleChannel INSTANCE = ChannelBuilder
            .named(new ResourceLocation(BeyondTheHorizon.MOD_ID, "main"))
            .networkProtocolVersion(PROTOCOL_VERSION)
            .simpleChannel();

    public static void register() {
        System.out.println("REGISTERED PACKET HANDLER");

        //Sync Packets
        {
            INSTANCE.messageBuilder(SyncPlayerFormS2C.class, NetworkDirection.PLAY_TO_CLIENT).encoder(SyncPlayerFormS2C::encode).decoder(SyncPlayerFormS2C::new).consumerMainThread(SyncPlayerFormS2C::handle).add();
            INSTANCE.messageBuilder(ParticleAuraPacketS2C.class, NetworkDirection.PLAY_TO_CLIENT).encoder(ParticleAuraPacketS2C::encode).decoder(ParticleAuraPacketS2C::new).consumerMainThread(ParticleAuraPacketS2C::handle).add();
            INSTANCE.messageBuilder(ParticleRaycastPacketS2C.class, NetworkDirection.PLAY_TO_CLIENT).encoder(ParticleRaycastPacketS2C::encode).decoder(ParticleRaycastPacketS2C::new).consumerMainThread(ParticleRaycastPacketS2C::handle).add();
            INSTANCE.messageBuilder(PlayerPlaySoundPacketS2C.class, NetworkDirection.PLAY_TO_CLIENT).encoder(PlayerPlaySoundPacketS2C::encode).decoder(PlayerPlaySoundPacketS2C::new).consumerMainThread(PlayerPlaySoundPacketS2C::handle).add();
            INSTANCE.messageBuilder(PlayerStopSoundPacketS2C.class, NetworkDirection.PLAY_TO_CLIENT).encoder(PlayerStopSoundPacketS2C::encode).decoder(PlayerStopSoundPacketS2C::new).consumerMainThread(PlayerStopSoundPacketS2C::handle).add();
        }

        //Base form
        {
            INSTANCE.messageBuilder(DoubleJump.class, NetworkDirection.PLAY_TO_SERVER).encoder(DoubleJump::encode).decoder(DoubleJump::new).consumerMainThread(DoubleJump::handle).add();
            INSTANCE.messageBuilder(DoubleJumpEnd.class, NetworkDirection.PLAY_TO_SERVER).encoder(DoubleJumpEnd::encode).decoder(DoubleJumpEnd::new).consumerMainThread(DoubleJumpEnd::handle).add();
        }

        //Super form
        {

        }

        //Starfall form
        {

        }

        //Hyper form
        {

        }
    }

    public static void sendToServer(Object msg) {
        INSTANCE.send(msg,PacketDistributor.SERVER.noArg());
    }

    public static void sendToPlayer(ServerPlayer player, Object msg) {
        INSTANCE.send(msg,PacketDistributor.PLAYER.with(player));
    }

    public static void sendToChunkPlayers(LevelChunk levelChunk, Object msg) {
        INSTANCE.send(msg,PacketDistributor.TRACKING_CHUNK.with(levelChunk));
    }

    public static void sendToALLPlayers(Object msg) {
        INSTANCE.send(msg,PacketDistributor.ALL.noArg());
    }

}
