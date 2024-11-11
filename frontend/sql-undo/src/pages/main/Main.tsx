import { useMutation } from "@tanstack/react-query";
import { useState } from "react";
import { undoScript } from "../../api/sqlUndoApi";
import { Script } from "../../models/script";

const Main: React.FC = () => {
    const [scriptText, setScriptText] = useState<string>("");
    const [reversedScript, setReversedScript] = useState<string>("");
    const [reverseError, setReverseError] = useState<string>("");

    const mutation = useMutation({
        mutationFn: undoScript,
        mutationKey: ["script"],
        onSuccess: setReversedScript,
        onError: setReverseError,
    });

    const undo = () => {
        const script: Script = {
            script: scriptText
        };

        mutation.mutate(script);
    }

    return <>
        <div className="w-screen h-screen">
            <div className="p-4 flex justify-center align-middle">
                <div id="script" className="w-full h-64">
                    <textarea className="border-2 w-full h-full resize-none p-2 text-sm" value={scriptText} onChange={(e) => setScriptText(e.target.value)} />
                </div>

                <div id="undone-script" className="w-full ml-5">
                    <textarea className="border-2 w-full h-full resize-none p-2 text-sm" value={reversedScript} disabled />
                </div>
            </div>

            <div className="flex w-full justify-between pl-4 pr-4 items-center">
                <div className="text-red-500 font-bold">
                    
                </div>

                <div className="flex justify-end align-middle">
                    <button className="border p-1 w-20 bg-blue-100 text-blue-900 border-blue-900 rounded-md" onClick={undo}>Undo</button>
                </div>
            </div>
        </div>
    </>
}

export default Main;