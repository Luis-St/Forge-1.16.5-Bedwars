package net.luis.bedwars.common.command.args;

import java.util.Arrays;
import java.util.Collection;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;

import net.luis.bedwars.base.util.ChatRank;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class ChatRankArgument implements ArgumentType<ChatRank> {
	
	private static final Collection<String> EXAMPLES = Arrays.asList("Spieler", "Premium");
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
		
		String string = reader.getString();
		ChatRank rank = ChatRank.byRankName(string);
		
		if (rank != null) {
			
			return rank;
			
		} else {
			
			throw CHAT_RANK_UNKNOWN.create(string);
			
		}
		
	}
	
//	@Override
//	public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
//		
//		return ISuggestionProvider.suggestIterable(ChatRank.rankNamesAsList(), builder);
//		
//	}
	
	@Override
	public Collection<String> getExamples() {
		
		return EXAMPLES;
		
	}

}
