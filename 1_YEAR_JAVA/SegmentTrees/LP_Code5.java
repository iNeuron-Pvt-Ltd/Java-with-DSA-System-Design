static class Node {
	int value;
	Node L, R;
}
static Node getnode() {
	Node temp = new Node();
	temp.value = 0;
	temp.L = null;
	temp.R = null;
	return temp;
}
