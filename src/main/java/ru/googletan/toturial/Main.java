package ru.googletan.toturial;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

@Plugin(
        id = "toturial",
        name = "Toturial",
        authors =
        {
        "GoogleTn"
        }
)
public class Main
{
    @Inject
    private static Logger logger;

    public static Logger getLogger() {return logger;}

    PluginContainer plugin = new PluginContainer()
    {
        @Override
        public String getId() {return "toturial";}
    };
    CommandSpec myCommandSpec = CommandSpec.builder()
            .description(Text.of("Hello World Command"))
            .permission("toturial.command.helloworld")
            .executor(new HelloWorldCommand())
            .build();


    @Listener
    public void onServerStart(GameStartedServerEvent event)
    {
        Sponge.getCommandManager().register(plugin, myCommandSpec, "helloworld", "hello", "test");
        logger.debug("Test");
    }
}
