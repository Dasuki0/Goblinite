package dasuki.goblinite.entity.client;

import dasuki.goblinite.Goblinite;
import dasuki.goblinite.entity.custom.GoblinEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GoblinModel extends AnimatedGeoModel<GoblinEntity> {
    @Override
    public Identifier getModelResource(GoblinEntity object) {
        return new Identifier(Goblinite.MOD_ID, "geo/goblin.geo.json");
    }

    @Override
    public Identifier getTextureResource(GoblinEntity object) {
        return new Identifier(Goblinite.MOD_ID, "textures/entity/goblin/goblin.png");
    }

    @Override
    public Identifier getAnimationResource(GoblinEntity animatable) {
        return new Identifier(Goblinite.MOD_ID, "animations/goblin.animation.json");
    }


    @Override
    public void setLivingAnimations(GoblinEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
