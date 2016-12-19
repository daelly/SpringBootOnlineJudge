var DefaultCode = new Array(3);
DefaultCode[0] = "#include <stdio.h>\nint main()\n{\n	\n	return 0;\n}";
DefaultCode[1] = "#include <iostream>\nusing namespace std;\nint main()\n{\n	\n	return 0;\n}";
DefaultCode[2] = "import java.util.*;\npublic class Main \n{\n	public static void main(String[] args)\n	{\n		\n	}\n}";
var codemirrorinit = false;
var editor;
$("#ShowCode").click(function () {
    $(this).colorbox({ inline: true, width: "690px", opacity: 0, closeButton: false });
    if (codemirrorinit == false) {
        editor = CodeMirror.fromTextArea(document.getElementById("CodeArea"), {
            lineNumbers: true,
            matchBrackets: true,
            indentUnit: 4,
            smartIndent: false,
            mode: "text/x-c++src",
            theme: "neat"
        });
        var lang;
        lang = parseInt($("#language").val());
        editor.setValue(DefaultCode[lang]);
        editor.setOption('mode', 'text/x-c++src');
        if (lang == 2)
            editor.setOption('mode', 'text/x-java');
        editor.save();
        codemirrorinit = true;
    }
    editor.refresh();
    setTimeout(function () { editor.refresh(); }, 500);
});
$("#language").change(function () {
    editor.save();
    var lang = $(this).val();
    lang = parseInt(lang);
    editor.setOption('mode', 'text/x-c++src');
    if (lang == 2)
        editor.setOption('mode', 'text/x-java');
    var ChangeContent = false;
    for (var i = 0; i <= 2; i++) {
        if (editor.getValue() == DefaultCode[i]) {
            ChangeContent = true;
            break;
        }
    }
    if (ChangeContent||editor.getValue()=='') {
        editor.setValue(DefaultCode[lang]);
    }
    editor.refresh();
});
$("#clearSrc").click(function(){
	editor.setValue('');
});