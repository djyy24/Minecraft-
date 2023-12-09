package com.djyy.gptvillager4.core.init;

import com.djyy.gptvillager4.common.items.Copyright;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMSI=DeferredRegister.create(ForgeRegistries.ITEMS,"gptvillager");
    public static final RegistryObject<Copyright> copyRight=ITEMSI.register("copy_right",()->new Copyright(new Item.Properties()));
}
