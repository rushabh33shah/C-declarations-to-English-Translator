package cs652.cdecl;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Tool {
	public static void main(String[] args) {
		// YOU MUST FILL THIS IN
		//Do not need main method to run tests.
	}

	public static String translate(String cdeclText) {
		ANTLRInputStream input = new ANTLRInputStream(cdeclText);
		CDeclLexer lexer = new CDeclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CDeclParser parser = new CDeclParser(tokens);
		ParseTree tree = parser.declaration();
		EnglishGenerator englishGenerator = new EnglishGenerator();
		String v = englishGenerator.visit(tree);
		return v;
	}
}
