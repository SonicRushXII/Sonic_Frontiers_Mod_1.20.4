package net.sonicrushxii.beyondthehorizon.modded;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sonicrushxii.beyondthehorizon.BeyondTheHorizon;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BeyondTheHorizon.MOD_ID);

    public static final RegistryObject<SoundEvent> DOUBLE_JUMP =
            registerSoundEvents("double_jump");
    public static final RegistryObject<SoundEvent> DANGER_SENSE =
            registerSoundEvents("danger_sense");
    public static final RegistryObject<SoundEvent> AIR_BOOST =
            registerSoundEvents("air_boost");
    public static final RegistryObject<SoundEvent> MAX_BOOST =
            registerSoundEvents("max_boost");
    public static final RegistryObject<SoundEvent> LIGHT_SPEED_CHARGE =
            registerSoundEvents("light_speed_charge");
    public static final RegistryObject<SoundEvent> POWER_BOOST =
            registerSoundEvents("power_boost");
    public static final RegistryObject<SoundEvent> DEPOWER_BOOST =
            registerSoundEvents("depower_boost");
    public static final RegistryObject<SoundEvent> HOMING_ATTACK =
            registerSoundEvents("homing_attack");
    public static final RegistryObject<SoundEvent> SPINDASH_CHARGE =
            registerSoundEvents("spindash_charge");
    public static final RegistryObject<SoundEvent> SPINDASH_RELEASE =
            registerSoundEvents("spindash_release");
    public static final RegistryObject<SoundEvent> BLITZ =
            registerSoundEvents("blitz");
    public static final RegistryObject<SoundEvent> SMASH_HIT =
            registerSoundEvents("smash_hit");
    public static final RegistryObject<SoundEvent> SMASH_CHARGE =
            registerSoundEvents("smash_charge");
    public static final RegistryObject<SoundEvent> STOMP =
            registerSoundEvents("stomp");

    private static RegistryObject<SoundEvent> registerSoundEvents(String soundName){
        return SOUND_EVENTS.register(soundName,
                ()->SoundEvent.createVariableRangeEvent(
                        new ResourceLocation(BeyondTheHorizon.MOD_ID,soundName)
                ));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
