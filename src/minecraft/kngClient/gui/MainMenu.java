package kngClient.gui;

import java.io.IOException;

import kngClient.Client;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen{
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 30, "Singleplayer"));
		this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 - 60, "Multiplayer"));
		this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 2 + 0, "Settings"));
		this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 2 + 30, "Exit Game"));
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("client/images/background.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		GlStateManager.pushMatrix();
		GlStateManager.translate(-(width/1.985f), -(height/2f), 0);
		GlStateManager.scale(2, 2, 2);
		
		this.drawCenteredString(mc.fontRendererObj, "KNGClient", this.width / 2, this.height / 2 - 100, -1);
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
	if(button.id == 0) {
		mc.displayGuiScreen(new GuiSelectWorld(this));	
	}
	if(button.id == 1) {
		mc.displayGuiScreen(new GuiMultiplayer(this));	
	}
	if(button.id == 2) {
		mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));	
	}
	if(button.id == 3) {
		mc.shutdown();
	}
		super.actionPerformed(button);
	}

}