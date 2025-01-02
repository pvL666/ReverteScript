import React, { useEffect, useState } from "react";
import { EditorState } from "@codemirror/state";
import { EditorView, keymap, lineNumbers } from "@codemirror/view";
import { sql } from "@codemirror/lang-sql";
import { Decoration, DecorationSet } from "@codemirror/view";
import Query from "../models/query";

interface SQLHoverEditorProps {
	queries: Query[];
}

const SQLHoverEditor: React.FC<SQLHoverEditorProps> = ({ queries }) => {
	const [tooltip, setTooltip] = useState<{ text: string; x: number; y: number } | null>(null);

	useEffect(() => {
		if (queries.length === 0) return;

		const revertedScript = queries.map((q) => q.reverted).join("\n");

		const decorations = Decoration.set(
			queries.map((query, index) =>
				Decoration.mark({
					attributes: {
						class: `query-${index}`,
						"data-original": query.original,
					},
				}).range(
					revertedScript.indexOf(query.reverted),
					revertedScript.indexOf(query.reverted) + query.reverted.length
				)
			)
		);

		const view = new EditorView({
			state: EditorState.create({
				doc: revertedScript,
				extensions: [
					sql(),
					lineNumbers(),
					EditorView.lineWrapping,
					EditorView.theme({
						"&": {
							color: "white",
							backgroundColor: "#202124",
						},
						".cm-content": {
							caretColor: "#0e9",
						},
						"&.cm-focused .cm-cursor": {
							borderLeftColor: "#0e9",
						},
						"&.cm-focused .cm-selectionBackground, ::selection": {
							backgroundColor: "#555",
						},
						"& .cm-decoration:hover": {
							backgroundColor: "rgba(14, 156, 255, 0.2)",
						},
						".cm-scroller": {
							overflow: "auto",
							maxHeight: "384px",
							scrollbarWidth: "thin",
						},
						".cm-scroller::-webkit-scrollbar": {
							width: "8px",
						},
						".cm-scroller::-webkit-scrollbar-thumb": {
							backgroundColor: "#444",
							borderRadius: "4px",
						},
						".cm-gutters": {
							backgroundColor: "#1e1e1e",
							color: "#999999",
							border: "none",
						},
						".cm-gutterElement": {
							padding: "0 8px",
						},
					}),
					EditorView.decorations.of(decorations),
					EditorView.domEventHandlers({
						mouseover: (event) => {
							const target = event.target as HTMLElement;
							const originalQuery = target.getAttribute("data-original");
							if (originalQuery) {
								const rect = target.getBoundingClientRect();
								const editorRect = document.querySelector("#editor")!.getBoundingClientRect();

								setTooltip({
									text: originalQuery,
									x: rect.left - editorRect.left,
									y: rect.top - editorRect.top - 20,
								});
							}
						},
						mouseout: () => setTooltip(null),
					}),
				],
			}),
			parent: document.querySelector("#editor")!,
		});

		return () => {
			view.destroy();
		};
	}, [queries]);

	return (
		<div className="relative w-full h-full bg-gray-900 text-gray-100 pl-4">
			<div id="editor" className="h-96 border border-gray-700 rounded-md">
				{tooltip && (
					<div
						style={{
							position: "absolute",
							top: tooltip.y,
							left: tooltip.x,
							backgroundColor: "rgba(0, 0, 0, 0.5)",
							color: "white",
							padding: "8px",
							borderRadius: "4px",
							zIndex: 1000,
							fontSize: "12px",
							maxWidth: "100%",
							wordWrap: "break-word"
						}}
					>
						{tooltip.text}
					</div>
				)}
			</div>
		</div>
	);
};

export default SQLHoverEditor;
