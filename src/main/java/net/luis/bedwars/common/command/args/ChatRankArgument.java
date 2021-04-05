package net.luis.bedwars.common.command.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import net.luis.bedwars.base.util.ChatRank;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ChatRankArgument implements ArgumentType<ChatRank> {
	
	private static final Collection<String> EXAMPLES = Arrays.asList("pig_hunter", "skeleton_sniper");
	public static final DynamicCommandExceptionType CHAT_RANK_UNKNOWN = new DynamicCommandExceptionType((chatRank) -> {
		return new TranslationTextComponent("chat_rank.unknown", chatRank);
	});
	
	public static ChatRankArgument chatRank() {
		
		return new ChatRankArgument();
		
	}
	
	public static ChatRank getChatRank(CommandContext<CommandSource> context, String name) {
		
		return context.getArgument(name, ChatRank.class);
		
	}

	@Override
	public ChatRank parse(StringReader reader) throws CommandSyntaxException {
		
		List<String> command = new ArrayList<String>(Arrays.asList(reader.getString().replace("/", "").split(" ")));
		List<String> locationPart = new ArrayList<String>(Arrays.asList(command.get(4).split(":")));
		ResourceLocation location = new ResourceLocation(locationPart.get(0), locationPart.get(1));
		ChatRank rank = ChatRank.byRankName(location);
		
		if (rank != null) {
			
			return rank;
			
		} else {
			
			throw CHAT_RANK_UNKNOWN.create(command.get(4));
			
		}
		
	}
	
	@Override
	public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
		
		return ISuggestionProvider.suggestIterable(ChatRank.rankLocationAsList(), builder);
		
	}
	
	@Override
	public Collection<String> getExamples() {
		
		return EXAMPLES;
		
	}

}
