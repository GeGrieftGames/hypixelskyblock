package de.langomatisch.skyblock.coins.event;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import java.util.UUID;

@Getter
public class PlayerCoinsChangeEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private UUID uuid;
    private int coinsNow, coinsBefore;
    private boolean cancelled;

    public PlayerCoinsChangeEvent(UUID uuid, int coinsNow, int coinsBefore) {
        this.uuid = uuid;
        this.cancelled = false;
        this.coinsBefore = coinsBefore;
        this.coinsNow = coinsNow;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
