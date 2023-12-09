package com.djyy.gptvillagermain.mixin;

import com.djyy.gptvillagermain.common.gui.screens.inventory.GptScreen;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screens.inventory.MerchantScreen.class)
public class MerchantScreen extends AbstractContainerScreen<MerchantMenu> {
    private static final ResourceLocation VILLAGER_LOCATION = new ResourceLocation("textures/gui/container/villager2.png");
    private int shopItem;
    // final net.minecraft.client.gui.screens.inventory.MerchantScreen.TradeOfferButton[] tradeOfferButtons = new net.minecraft.client.gui.screens.inventory.MerchantScreen.TradeOfferButton[7];
    public MerchantScreen(MerchantMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @Inject(method = {"render"},at = {@At(value = "INVOKE",target = "Lcom/mojang/blaze3d/systems/RenderSystem;enableDepthTest()V",shift = At.Shift.AFTER)},cancellable = true)
    public void render(PoseStack p_99148_, int p_99149_, int p_99150_, float p_99151_, CallbackInfo ci) {
        //System.out.print("我的世界");
        Button bt1;
        bt1=new Button(this.width/2+63,this.height/2-23,40,20, new TextComponent("Chating"),(button)->{
            Minecraft.getInstance().setScreen(new GptScreen(new TextComponent("gptTest"),this.title.getString()));
        });
        this.addWidget(bt1);
        //System.out.println("标题："+this.title.getString());
        bt1.render(p_99148_,p_99149_,p_99150_,p_99151_);
    }

    @Override
    protected void renderBg(PoseStack p_99143_, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, VILLAGER_LOCATION);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        blit(p_99143_, i, j, this.getBlitOffset(), 0.0F, 0.0F, this.imageWidth, this.imageHeight, 512, 256);
        MerchantOffers merchantoffers = this.menu.getOffers();
        if (!merchantoffers.isEmpty()) {
            int k = this.shopItem;
            if (k < 0 || k >= merchantoffers.size()) {
                return;
            }

            MerchantOffer merchantoffer = merchantoffers.get(k);
            if (merchantoffer.isOutOfStock()) {
                RenderSystem.setShaderTexture(0, VILLAGER_LOCATION);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                blit(p_99143_, this.leftPos + 83 + 99, this.topPos + 35, this.getBlitOffset(), 311.0F, 0.0F, 28, 21, 512, 256);
            }
        }
    }
}
