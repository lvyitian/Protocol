package com.nukkitx.protocol.bedrock.v332.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.SetLocalPlayerAsInitializedPacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SetLocalPlayerAsInitializedSerializer_v332 implements PacketSerializer<SetLocalPlayerAsInitializedPacket> {
    public static final SetLocalPlayerAsInitializedSerializer_v332 INSTANCE = new SetLocalPlayerAsInitializedSerializer_v332();


    @Override
    public void serialize(ByteBuf buffer, SetLocalPlayerAsInitializedPacket packet) {
        VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
    }

    @Override
    public void deserialize(ByteBuf buffer, SetLocalPlayerAsInitializedPacket packet) {
        packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
    }
}
