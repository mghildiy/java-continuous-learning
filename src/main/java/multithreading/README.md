Things to know and remember:

1. Threads run independently
2. Concurrency and parallelism are different things
3. Creating platform threads(virtual threads are cheap) is expensive as every new thread creation may take
   2 MB of non-heap monolithic memory blocks(not GCable)
4. Context switching between threads is expensive
5. NEVER rely on order of thread execution OR scheduling for program's correctness,
   no matter how much your tests hint 'all is fine'
6. ALWAYS think of manipulating threads from API's prism, so try to expertise how thread API works
7. DONT make threads consume CPU cycles but doing nothing, like blocked for some IO result OR result of another thread
8. So if data is not available, suspend the thread until its available(join, wait, notify, notifyAll etc etc)
9. Understand CPU caches and how JVM works with it via volatile, synchronized blocks etc
10. Thread suspension over blocking
11. Reduce latency by breaking a task into sub-parts and running those sub-parts in parallel, followed by aggregating the results
12. Breaking a small task to run in parallel in not worth it as time consumed in breaking, starting and scheduling threads,
    and aggregating the results most of the time offsets the advantage gained by parallelism
13. If there is no blocking code, then having more threads than number of cores is counter-productive
14. Creating new threads is expensive, so use thread pools as much as possible
15. To improve throughput of system, you can break a task into subparts and assign those parts to threads.
    But breaking, scheduling, aggregating itself are time consuming steps. So better assign entire tasks to threads if possible