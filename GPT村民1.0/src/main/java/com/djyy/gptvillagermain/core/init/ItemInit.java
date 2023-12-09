package com.djyy.gptvillagermain.core.init;

import com.djyy.gptvillagermain.common.items.Copyright;
import com.djyy.gptvillagermain.common.items.EatingTest;
import com.djyy.gptvillagermain.common.items.GptTest;
import com.djyy.gptvillagermain.common.items.UseTest;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMSI=DeferredRegister.create(ForgeRegistries.ITEMS,"gptvillagemain");
    public static final RegistryObject<Copyright> copyRight=ITEMSI.register("copy_right",()->new Copyright(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<GptTest> gptTest=ITEMSI.register("gpt_test",()->new GptTest(new Item.Properties()));
    public static final RegistryObject<UseTest> useTest=ITEMSI.register("use_test",()->new UseTest(new Item.Properties()));
    public static final RegistryObject<EatingTest> eatingTest=ITEMSI.register("eating_test",()->new EatingTest(new Item.Properties()));
}
