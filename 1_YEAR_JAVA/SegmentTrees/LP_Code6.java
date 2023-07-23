class Main {
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

	static Node root = new Node();
	static void UpdateHelper(Node curr, int index, int L, int R, int val) {
		if (L > index || R < index) return;
		if (L == R && L == index) {
			curr.value = val;
			return;
		}

		int mid = L - (L - R) / 2;
		int sum1 = 0, sum2 = 0;
		if (index <= mid) {
			if (curr.L == null)	curr.L = getnode();
			UpdateHelper(curr.L, index, L, mid, val);
		}
		else {
			if (curr.R == null) curr.R = getnode();
			UpdateHelper(curr.R, index, mid + 1, R, val);
		}
		if (curr.L != null) sum1 = curr.L.value;

		if (curr.R != null)	sum2 = curr.R.value;
		curr.value = sum1 + sum2;
		return;
	}

	static int queryHelper(Node curr, int a, int b, int L, int R) {
		if (curr == null) return 0;
		if (L > b || R < a) return 0;
		if (L >= a && R <= b) return curr.value;
		int mid = L - (L - R) / 2;
		return queryHelper(curr.L, a, b, L, mid) + queryHelper(curr.R, a, b, mid + 1, R);
	}
	static int query(int L, int R) {
		return queryHelper(root, L, R, 1, 10);
	}
	static void update(int index, int value) {
		UpdateHelper(root, index, 1, 10, value);
	}
	static void operations() {
		root = getnode();
		update(1, 10);
		update(3, 5);
		System.out.println(query(2, 8));
		System.out.println(query(1, 10));

	}
	public static void main(String[] args) {
		operations();
	}
}