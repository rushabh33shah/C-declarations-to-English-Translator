package cs652.cdecl;

public class EnglishGenerator extends CDeclBaseVisitor<String> {
    @Override
    public String visitDeclaration(CDeclParser.DeclarationContext ctx) {

        return String.valueOf(visit(ctx.declarator()))+visit(ctx.typename());
    }
    @Override
    public String visitPointer(CDeclParser.PointerContext ctx) {

        return visit(ctx.declarator())+"pointer to ";
    }

    @Override
    public String visitGrouping(CDeclParser.GroupingContext ctx) {

        return visit(ctx.declarator());
    }

    @Override
    public String visitTypename(CDeclParser.TypenameContext ctx) {
        String value="";
        if(String.valueOf(ctx.getText()).contains("void"))
        {
            value="nothing";
        }
        else
        {
            value =String.valueOf(ctx.getText());
        }
        return value;
    }

    @Override
    public String visitArray(CDeclParser.ArrayContext ctx) {

        return visit(ctx.declarator())+"array of ";
    }

    @Override
    public String visitFunc(CDeclParser.FuncContext ctx) {

        return visit(ctx.declarator())+"function returning ";
    }

    @Override
    public String visitVar(CDeclParser.VarContext ctx) {
        return String.valueOf(ctx.getText())+" is a ";
    }
}
