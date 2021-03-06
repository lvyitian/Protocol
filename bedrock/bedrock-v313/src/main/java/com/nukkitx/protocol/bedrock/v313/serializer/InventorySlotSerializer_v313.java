package com.nukkitx.protocol.bedrock.v313.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.InventorySlotPacket;
import com.nukkitx.protocol.bedrock.v313.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventorySlotSerializer_v313 implements PacketSerializer<InventorySlotPacket> {
    public static final InventorySlotSerializer_v313 INSTANCE = new InventorySlotSerializer_v313();

    @Override
    public void serialize(ByteBuf buffer, InventorySlotPacket packet) {
        VarInts.writeUnsignedInt(buffer, packet.getContainerId());
        VarInts.writeUnsignedInt(buffer, packet.getSlot());
        BedrockUtils.writeItemData(buffer, packet.getItem());
    }

    @Override
    public void deserialize(ByteBuf buffer, InventorySlotPacket packet) {
        packet.setContainerId(VarInts.readUnsignedInt(buffer));
        packet.setSlot(VarInts.readUnsignedInt(buffer));
        packet.setItem(BedrockUtils.readItemData(buffer));
    }
}
