package dasuki.goblinite;

import dasuki.goblinite.entity.ModEntities;
import dasuki.goblinite.entity.client.GoblinRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class GobliniteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.GOBLIN, GoblinRenderer::new);
    }
}
