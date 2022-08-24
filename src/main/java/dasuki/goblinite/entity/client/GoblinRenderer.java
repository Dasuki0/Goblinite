package dasuki.goblinite.entity.client;

import dasuki.goblinite.Goblinite;
import dasuki.goblinite.entity.custom.GoblinEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoblinRenderer extends GeoEntityRenderer<GoblinEntity> {
    public GoblinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GoblinModel());
    }

    @Override
    public Identifier getTextureResource(GoblinEntity instance) {
        return new Identifier(Goblinite.MOD_ID, "textures/entity/goblin/goblin.png");
    }
}
