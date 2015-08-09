package com.arun.graph;

/**
 * The idea is to use DFS traversal to find a job for an applicant (similar to augmenting path in Ford-Fulkerson). 
 * We call bpm() for every applicant, bpm() is the DFS based function that tries all possibilities to assign a job to the applicant.
 * 
 * In bpm(), we one by one try all jobs that an applicant ‘u’ is interested in until we find a job, or all jobs are tried without luck. 
 * For every job we try, we do following.	
 * 				If a job is not assigned to anybody, we simply assign it to the applicant and return true. 
 * 				If a job is assigned to somebody else say x, then we recursively check whether x can be assigned some other job. 
 * To make sure that x doesn’t get the same job again, we mark the job ‘v’ as seen before we make recursive call for x. 
 * If x can get other job, we change the applicant for job ‘v’ and return true. 
 * 
 * We use an array maxR[0..N-1] that stores the applicants assigned to different jobs.
 * @author Arun
 *
 */
public class MaxBipartiteMatching {
	
	int findMaxBipartite(Graph g) {
		
		int[] match = new int[g.countVertex];
		int count = 0;
		
		for (int i = 0; i < match.length; i++) {
			match[i] = -1;
		}
		
		for (int u = 0; u < g.countVertex; u++) {
			
			boolean[] seen = new boolean[g.countVertex];
			
			if(bpm(g, u, match, seen)) {
				count++;
			}
				
		}
		return count;
	}

	private boolean bpm(Graph g, int u, int[] match, boolean[] seen) {
		for (int v = 0; v < g.countVertex; v++) {
			
			if (g.adjMatrix[u][v] != 0 && !seen[v]) {
				
				seen[v] = true;
				
				if (match[v] == -1 || bpm(g, match[v], match, seen)) {
					match[v] = u;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(12, true);
		
		g.addEdge(0, 7);
		g.addEdge(0, 8);
		g.addEdge(2, 6);
		g.addEdge(2, 9);
		g.addEdge(3, 8);
		g.addEdge(4, 8);
		g.addEdge(4, 9);
		g.addEdge(5, 11);
		
		MaxBipartiteMatching mbm = new MaxBipartiteMatching();
		System.out.println(mbm.findMaxBipartite(g));
		
	}
}
